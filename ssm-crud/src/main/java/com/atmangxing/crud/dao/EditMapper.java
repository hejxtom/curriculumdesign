package com.atmangxing.crud.dao;

import com.atmangxing.crud.bean.Edit;
import com.atmangxing.crud.bean.EditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EditMapper {
    long countByExample(EditExample example);

    int deleteByExample(EditExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Edit record);

    int insertSelective(Edit record);

    List<Edit> selectByExample(EditExample example);
    List<Edit> selectAll();

    Edit selectByPrimaryKey(Integer id);
    List<Edit> selectWithstusId(Integer stusId);

    int updateByExampleSelective(@Param("record") Edit record, @Param("example") EditExample example);

    int updateByExample(@Param("record") Edit record, @Param("example") EditExample example);

    int updateByPrimaryKeySelective(Edit record);

    int updateByPrimaryKey(Edit record);
}