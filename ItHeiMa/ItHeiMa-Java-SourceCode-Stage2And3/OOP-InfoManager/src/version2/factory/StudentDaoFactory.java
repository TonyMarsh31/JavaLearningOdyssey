package version2.factory;

import version2.dao.BaseStudentDao;
import version2.dao.OtherStudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
    }
}
