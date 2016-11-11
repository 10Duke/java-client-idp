package com.tenduke.client.api.idp;

import java.io.Serializable;

public class errorModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private int code;


    /** Returns message
     *
     *  @return message 
     */

    public String getMessage () {
        return this.message;
    }


    /** Sets message
     *
     *  @param message 
     */

    public void setMessage (final String message) {
        this.message = message;
    }


    /** Returns code
     *
     *  @return code 
     */

    public int getCode () {
        return this.code;
    }


    /** Sets code
     *
     *  @param code 
     */

    public void setCode (final int code) {
        this.code = code;
    }

}
