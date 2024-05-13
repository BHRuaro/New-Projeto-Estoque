package br.inf.brunoruaro.error;

import java.io.Serial;
import java.io.Serializable;

public class ApiException extends Exception implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public ApiException(String msg)	{
        super(msg);
    }

}
