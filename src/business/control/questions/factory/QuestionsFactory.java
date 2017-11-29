package business.control.questions.factory;

import business.control.adapter.AdapterImport;
import business.control.adapter.JsonImport;
import business.control.util.MysqlConnect;
import business.model.questions.Questions;
import java.sql.SQLException;

public abstract class QuestionsFactory {

    public Questions createQuestion(String importFile) throws SQLException {
        try {
            MysqlConnect mysql = MysqlConnect.getDbCon();
            AdapterImport adapter = new JsonImport();
            Questions question = adapter.parseData(importFile);

            mysql.insert("INSERT INTO `questions` (`statment`, `alternative1`, `alternative2`, `alternative3`, `alternative4`, `alternative5`, `correct`) VALUES "
                    + "('" + question.getStatment() + "', '" + question.getAlternative1() + "', '" + question.getAlternative2() + "', '" + question.getAlternative3() + "', '"
                    + question.getAlternative4() + "', '" + question.getAlternative5() + "', '" + question.getCorrect() + "')");

            return question;
        } catch (SQLException error) {
            System.out.println("Error: " + error);
        }
        return null;
    }
}