package cn.com.mabatis.test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.po.User;

public class MyBatisTest {
	
	public DataConnection dataConn = new DataConnection();
	@Test
	public void TestSelect() throws IOException{
		SqlSession sqlSession = dataConn.getSqlSession();
			//sqlSession.selectOne���ս����ӳ���ļ���ƥ���resultType����
			User user = sqlSession.selectOne("test.findUserById",1);
			System.out.println("����:"+user.getUsername());
			System.out.println("�Ա�:"+user.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("����:"+sdf.format(user.getBirthday()));
			System.out.println("���ڵ�:"+user.getProvince()+user.getCity());
			sqlSession.close();
	}

}
