package com.lsm.accountBook.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3646177092323138288L;

    private int code;

    private String description;

}
