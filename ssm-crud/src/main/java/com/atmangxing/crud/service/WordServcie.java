package com.atmangxing.crud.service;

import com.atmangxing.crud.bean.Word;
import com.atmangxing.crud.bean.WordExample;
import com.atmangxing.crud.dao.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServcie {
     @Autowired
    WordMapper wordMapper;

    public List<Word> getByClassId(Integer classId) {
        // TODO Auto-generated method stub
        return wordMapper.selectByClassId(classId);
    }

    public List<Word> getWithClass() {
        // TODO Auto-generated method stub
        return wordMapper.selectByExampleWithClass(null);
    }


    /**
     * 查询所有
     * @return
     */
    public List<Word> getWord() {
        // TODO Auto-generated method stub
        return wordMapper.selectByExample(null);
    }

    /**
     * 保存
     * @param word
     */
    public void saveEmp(Word word) {
        // TODO Auto-generated method stub
        wordMapper.insertSelective(word);
    }
    /**
     * 按照id查询
     * @param id
     * @return
     */
    public Word getEmp(Integer id) {
        // TODO Auto-generated method stub
        Word word = wordMapper.selectByPrimaryKey(id);
        return word;
    }

    /**
     * 更新
     * @param word
     */
    public void updateEmp(Word word) {
        // TODO Auto-generated method stub
        wordMapper.updateByPrimaryKeySelective(word);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        // TODO Auto-generated method stub
        wordMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        WordExample example = new WordExample();
        WordExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andWordIdIn(ids);
        wordMapper.deleteByExample(example);
    }

}
