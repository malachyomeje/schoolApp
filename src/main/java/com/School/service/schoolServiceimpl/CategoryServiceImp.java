package com.School.service.schoolServiceimpl;

import com.School.dto.request.CategoryDto;
import com.School.dto.response.BaseResponse;
import com.School.libraryModel.Category;
import com.School.repository.CategoryRepository;
import com.School.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    private  final CategoryRepository categoryRepository;
    @Override
    public BaseResponse registerCategory (CategoryDto categoryDto){
        Optional<Category>categoryDto1= categoryRepository.findByCategoryName(categoryDto.getCategoryName());
        if (categoryDto1.isPresent()) {
            return new BaseResponse<>("Category is Present ", categoryDto.getCategoryName());
        }
            Category category =  Category.builder()
                    .categoryName(categoryDto.getCategoryName())
                    .description(categoryDto.getDescription())
                    .imageUrl(categoryDto.getImageUrl())

                    .build();
            categoryRepository.save(category);


        return new BaseResponse<>("Registration complete",category);
    }
}
