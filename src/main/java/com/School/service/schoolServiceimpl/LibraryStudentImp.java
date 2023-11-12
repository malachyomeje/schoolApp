package com.School.service.schoolServiceimpl;

import com.School.dto.request.BorrowedBookDto;
import com.School.dto.request.LibraryStudentDto;
import com.School.dto.response.BaseResponse;
import com.School.libraryModel.Book;
import com.School.libraryModel.BorrowedBook;
import com.School.libraryModel.LibraryStudent;
import com.School.repository.BookRepository;
import com.School.repository.LibraryStudentRepository;
import com.School.repository.SchoolRepository;
import com.School.schoolModel.School;
import com.School.service.LibraryStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LibraryStudentImp implements LibraryStudentService {
    private final SchoolRepository schoolRepository;
    private  final LibraryStudentRepository libraryStudentRepository;
    private final BookRepository bookRepository;



    @Override
    public BaseResponse registerLibraryStudent(String studentEmail){
        Optional<School> school = schoolRepository.findByEmail(studentEmail);

        if (school.isEmpty()){
            return new BaseResponse<>("NOT A STUDENT"+studentEmail);
        }

        Optional<LibraryStudent> libraryStudent = libraryStudentRepository.findByEmail(studentEmail);

        if (libraryStudent.isPresent()){
            return new BaseResponse<>("STUDENT ALREADY REGISTERED"+studentEmail);
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

       return new BaseResponse<>("REGISTRATION COMPLETE",libraryStudent1);
    }
   public  BaseResponse borrowBook (BorrowedBookDto borrowedBookDto){

       String email = SecurityContextHolder.getContext().getAuthentication().getName();

       Optional<LibraryStudent> libraryStudent = libraryStudentRepository.findByEmail(email);

       if (libraryStudent.isEmpty()){
           return new BaseResponse<>("STUDENT NOT REGISTERED"+borrowedBookDto.getBorrowedBooks());
       }
       Optional<Book> bookOptional = bookRepository.findByBookName(borrowedBookDto.getBookName());

       if (bookOptional.isEmpty()){
           return new BaseResponse<>("BOOK IS NOT FOUND"+borrowedBookDto.getBorrowedBooks());
       }

       Book book = bookOptional.get();
       LibraryStudent libraryStudent1 =libraryStudent.get();

       BorrowedBook borrowedBook = new BorrowedBook();
//               .name(libraryStudent1.getName())
//               .email(borrowedBookDto.getEmail())
//               .borrowedBook(borrowedBookDto.getBorrowedBooks())
//
//               .build();

       return null;
   }
}
