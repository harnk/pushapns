package nd.tesserae.phoneagent.pushapns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dscottnull on 7/24/18.
 */
@Configuration
public class DBInitializeConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS push_queue_sandbox");
            statement.executeUpdate(
                    "CREATE TABLE push_queue_sandbox(" +
                            "id INTEGER Primary key, " +
                            "device_token varchar(128) not null," +
                            "payload varchar(256) not null," +
                            "time_queued bigint not null, " +
                            "time_sent bigint)"
            );
            statement.executeUpdate(
                    "INSERT INTO push_queue_sandbox " +
                            "(device_token,payload,time_queued) " +
                            "VALUES " + "('c5896eb978ad12ce09e0f14eace8d073a45e94b0301e9ce4eda6983c10edda89',"
                            + "'{\"aps\":{\"badge\":1,\"alert\":\"PUSHAPNS Msg to sandbox device ...\",\"sound\":\"beep.caf\"}',"
                            + " 1529596838745)"
            );
//            statement.executeUpdate(
//                    "INSERT INTO person " +
//                            "(uid,hashed_pass,app_version,bundle_id,system_version,device_info,push_token,is_sandbox,device_bind_at,created_at,file_uploaded_at,os_type,device_session_token) " +
//                            "VALUES " + "('harnk00000a','pwd','3.4999','tesserae.phoneagent.pushapns','11.3.1.99','iPhone13,1','36c67b3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4',0,1529596876820,1513632469879,1529597411388,'ios','i0wth0is0going0n')"
//            );
//            statement.executeUpdate(
//                    "INSERT INTO person " +
//                            "(uid,hashed_pass,app_version,bundle_id,system_version,device_info,push_token,is_sandbox,device_bind_at,created_at,file_uploaded_at,os_type,device_session_token) " +
//                            "VALUES " + "('harnk00000b','pwd','3.4999','tesserae.phoneagent.pushapns','11.3.1.99','iPhone13,1','zzyzxb3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4',1,1529596876820,1513632469879,1529597411388,'ios','i0wth0is0going0n')"
//            );
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
