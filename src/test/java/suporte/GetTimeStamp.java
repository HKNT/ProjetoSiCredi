package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GetTimeStamp {
    public static String dataHora(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
