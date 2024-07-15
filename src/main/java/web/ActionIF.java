package web;

import javax.servlet.http.HttpServletRequest;

import common.SystemException;

public interface ActionIF {

    public String execute(HttpServletRequest request) throws SystemException;
}
