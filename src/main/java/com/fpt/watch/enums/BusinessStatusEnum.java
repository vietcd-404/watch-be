package com.fpt.watch.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author watch
 * @since 5/4/2024
 */
@Getter
@AllArgsConstructor
public enum BusinessStatusEnum implements BaseEnum<T> {

    SUCCESS(200, "Thành công."),
    ERROR(300, "Thất bại."),
    FILE_NOT_EXIST(400, "File không tồn tại."),
    FILE_READ_ERROR(500, "Đọc file không thành công."),
    FILE_WRITE_ERROR(600, "Ghi file không thành công."),
    FILE_UPLOAD_ERROR(700, "Tải file lên không thành công."),
    TOKEN_NOT_EXIST(800, "token không tồn tại，vui lòng đăng nhập lại."),
    TOKEN_INVALID(900, "token không hợp lệ，vui lòng đăng nhập lại."),
    DATA_IMPORT_ERROR(1000, "Import dữ liệu không thành công."),
    BATCH_DELETE_ERROR(1100, "Xóa hàng loạt không thành công."),
    STAFF_NOT_EXIST(1200,"Nhân viên này không tồn tại，vui lòng đăng nhập lại."),
    STAFF_STATUS_ERROR(1300, "Trạng thái không hợp lệ，liên hệ admin để biết thêm chi tiết.");

    private final Integer code;
    private final String message;
}
