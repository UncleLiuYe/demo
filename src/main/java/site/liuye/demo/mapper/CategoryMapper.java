package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.liuye.demo.entity.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    Category findById(Long id);

    List<Category> findAll();

    Category findByName(String name);

    void insertCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);

    List<Category> findAllCategories(@Param("offset") int offset, @Param("limit") int limit);

    int countAllCategories();
}