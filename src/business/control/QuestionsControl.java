package business.control;

import business.control.util.MysqlConnect;
import business.model.exception.QuestionNotExistException;
import business.model.questions.Questions;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QuestionsControl {

    public static ResultSet getQuestion(int id) throws QuestionNotExistException {
        try {
            MysqlConnect mysql = MysqlConnect.getDbCon();
            return mysql.query("SELECT * FROM `questions` WHERE id = '" + id + "';");
        } catch (SQLException error) {
            System.out.println("Error: " + error);
        }
        return null;
    }
}