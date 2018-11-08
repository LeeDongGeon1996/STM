package kw.comso.service;

import java.util.ArrayList;

import kw.comso.dto.QuestionVO;
import kw.comso.dto.TestPaperVO;

public interface QuestionService {
   
   QuestionVO getQuestion(int questionID);
   ArrayList<QuestionVO> getQuestion(String memberID);
   TestPaperVO getTestPaper_one(String testPaperID);
   ArrayList<TestPaperVO> getTestPaper(String memberID);
   boolean registerQuestion(String memberID, QuestionVO question);
   boolean deleteQuestion(Long questionID);
   boolean registerTestPaper(String memberID, TestPaperVO testPaper);
   boolean deleteTestPaper(Long testPaperID);
}