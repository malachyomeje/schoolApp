package com.School.service.schoolServiceimpl;

import com.School.dto.request.LibraryDto;
import com.School.dto.response.BaseResponse;
import com.School.model.Library;
import com.School.repository.LibraryRepository;
import com.School.repository.StudentRepository;
import com.School.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryServiceImp implements LibraryService {

    private final StudentRepository studentRepository;
    private final LibraryRepository libraryRepository;



@Override
    public BaseResponse libraryRegistration(LibraryDto libraryDto){
        Optional<Library> library = libraryRepository.findByBookName(libraryDto.getBookName());

        if (library.isPresent()) {
            return  new BaseResponse<>("BOOK ALREADY EXIST", libraryDto.getBookName());
        }
        Library library1 = Library.builder()
                .bookName(libraryDto.getBookName())
                .author(libraryDto.getAuthor())
                .numberOfBooks(libraryDto.getNumberOfBooks())
                .isbnNo(libraryDto.getIsbnNo())
                .build();

        libraryRepository.save(library1);
        return new BaseResponse<>("BOOK REGISTRATION SUCCESSFUL",library1);
    }


}
