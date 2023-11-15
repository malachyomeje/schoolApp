package com.School.service.schoolServiceimpl;

import com.School.dto.request.BorrowedBookDto;
import com.School.dto.request.EmailDto;
import com.School.dto.response.BaseResponse;
import com.School.libraryModel.Book;
import com.School.libraryModel.BorrowedBook;
import com.School.libraryModel.LibraryStudent;
import com.School.repository.BookRepository;
import com.School.repository.BorrowedBookRepository;
import com.School.repository.LibraryStudentRepository;
import com.School.repository.SchoolRepository;
import com.School.schoolModel.School;
import com.School.service.LibraryStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LibraryStudentImp implements LibraryStudentService {
    private final SchoolRepository schoolRepository;
    private final LibraryStudentRepository libraryStudentRepository;
    private final BookRepository bookRepository;
    private final BorrowedBookRepository borrowedBookRepository;


    @Override
    public BaseResponse registerLibraryStudent(String studentEmail) {
        Optional<School> school = schoolRepository.findByEmail(studentEmail);

        if (school.isEmpty()) {
            return new BaseResponse<>("NOT A STUDENT" + studentEmail);
        }

        Optional<LibraryStudent> libraryStudent = libraryStudentRepository.findByEmail(studentEmail);

        if (libraryStudent.isPresent()) {
            return new BaseResponse<>("STUDENT ALREADY REGISTERED" + studentEmail);
        }

        School school1 = school.get();

        LibraryStudent libraryStudent1 = LibraryStudent.builder()
                .firstName(school1.getFirstName())
                .lastName(school1.getLastName())
                .email(school1.getEmail())
                .department(school1.getDepartment())
                .phoneNumber(school1.getPhoneNumber())
                .registrationNo(school1.getRegistrationNo())
                .faculty(school1.getFaculty())
                .sex(school1.getSex())
                .build();

        libraryStudentRepository.save(libraryStudent1);

        return new BaseResponse<>("REGISTRATION COMPLETE", libraryStudent1);
    }


    @Override
    public BaseResponse borrowBook(BorrowedBookDto borrowedBookDto) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<LibraryStudent> libraryStudent = libraryStudentRepository.findByEmail(email);

        if (libraryStudent.isEmpty()) {
            return new BaseResponse<>("STUDENT NOT REGISTERED" + email);
        }
        Book book = bookRepository.findByBookName(borrowedBookDto.getBookName()).orElse(null);

        if (book == null) {
            return new BaseResponse<>("BOOK IS NOT FOUND  " + borrowedBookDto.getBookName());
        }

        LibraryStudent libraryStudent1 = libraryStudent.get();
        List<BorrowedBook> lab = libraryStudent1.getBorrowedBook();

        BorrowedBook borrowedBook = BorrowedBook.builder()
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .isbnNo(book.getIsbnNo())
                .libraryStudent(libraryStudent1.getEmail())
                .build();
        lab.add(borrowedBook);
        borrowedBookRepository.save(borrowedBook);
        return new BaseResponse<>("successful", borrowedBook);

    }

    @Override
    public BaseResponse returnBook(BorrowedBookDto borrowedBookDto) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<LibraryStudent> libraryStudent = libraryStudentRepository.findByEmail(email);

        if (libraryStudent.isEmpty()) {
            return new BaseResponse<>("STUDENT NOT REGISTERED" + email);
        }
        LibraryStudent libraryStudent1 = libraryStudent.get();
        List<BorrowedBook> lab = libraryStudent1.getBorrowedBook();

        lab.removeIf(borrowedBook -> borrowedBook.getBookName().equals(borrowedBookDto.getBookName()) &&
                (borrowedBook.getAuthor().equals(borrowedBookDto.getAuthor())));

        libraryStudentRepository.save(libraryStudent1);

        return new BaseResponse("TOU HAVE SUCCESSFULLY RETURN " + borrowedBookDto.getBookName());
    }



   // @Scheduled(cron = "0 3 0 * * ?")
    @Scheduled(fixedRate = 180000)
    public void autoReturn() {

        List<BorrowedBook> libraryStudent = borrowedBookRepository.findAll();


            for (BorrowedBook borrowedBook : libraryStudent) {

                libraryStudent.remove(borrowedBook);

                break;
            }



        }
    }





