package utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;

public class MyUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    
    // Lưu trữ Connection vào attribute của request.
    // Thông tin lưu trữ này chỉ tồn tại trong thời gian yêu cầu (request)
    // cho tới khi dữ liệu được trả về trình duyệt người dùng.
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
    // Lấy đối tượng Connection đã được lưu trữ trong attribute của request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
}
