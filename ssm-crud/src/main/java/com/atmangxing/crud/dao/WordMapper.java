package com.atmangxing.crud.dao;

import com.atmangxing.crud.bean.Word;
import com.atmangxing.crud.bean.WordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WordMapper {
    long countByExample(WordExample example);

    int deleteByExample(WordExample example);

    int deleteByPrimaryKey(Integer wordId);

    int insert(Word record);

    int insertSelective(Word record);

    List<Word> selectByExample(WordExample example);
    List<Word> selectByExampleWithClass(WordExample example);
    List<Word> selectByClassId(Integer classId);

    Word selectByPrimaryKey(Integer wordId);

    int updateByExampleSelective(@Param("record") Word record, @Param("example") WordExample example);

    int updateByExample(@Param("record") Word record, @Param("example") WordExample example);

    int updateByPrimaryKeySelective(Word record);

    int updateByPrimaryKey(Word record);
}