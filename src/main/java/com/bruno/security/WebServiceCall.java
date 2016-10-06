package com.bruno.security;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.ddway.authentication.AuthenticateRequest;
import it.ddway.authentication.AuthenticateResponse;
import it.ddway.authentication.IntegraBDAPSoapProxy;
import it.ddway.authentication.OrganizationRequest;
import it.ddway.authentication.OrganizationResponse;
import it.ddway.authentication.Organizzazione;
import it.ddway.authentication.UserInfo;
import it.ddway.authentication.UserInfoExt;
import it.ddway.authentication.UserInfoResponse;

public class WebServiceCall {

    private static final Logger log = LoggerFactory.getLogger(WebServiceCall.class);

    public UserInfo callAuthenticate(String token) throws Exception {
	log.info("Start WebServiceCall.callAuthenticate method");

	Properties props;
	String endpoint;

	AuthenticateRequest authenticateRequest = new AuthenticateRequest(token);
	AuthenticateResponse authenticateResponse = null;
	IntegraBDAPSoapProxy integraBDAPSoap = new IntegraBDAPSoapProxy();

	try {
	    props = getFileProperties("/properties/web_service.properties");
	    endpoint = props.getProperty("end_point");
	    integraBDAPSoap.setEndpoint(endpoint);
	    authenticateResponse = integraBDAPSoap.authenticate(authenticateRequest);
	} catch (Exception e) {
	    log.error("Exception invoked in method WebServiceCall.callAuthenticate: " + e.toString());
	    throw e;
	}
	return authenticateResponse.getUserInfo();
    }

    public Organizzazione callOrganization(int code) throws Exception {
	log.info("Start WebServiceCall.callOrganization method");

	String endpoint;
	Properties props;
	OrganizationRequest organizationRequest = new OrganizationRequest(code);
	OrganizationResponse organizationResponse = null;
	IntegraBDAPSoapProxy integraBDAPSoap = new IntegraBDAPSoapProxy();

	try {
	    props = getFileProperties("/properties/web_service.properties");
	    endpoint = props.getProperty("end_point");
	    integraBDAPSoap.setEndpoint(endpoint);
	    organizationResponse = integraBDAPSoap.organization(organizationRequest);
	} catch (Exception e) {
	    log.error("Exception invoked in method WebServiceCall.callOrganization: " + e.toString());
	    throw e;
	}
	return organizationResponse.getOrganizzazione();
    }

    public UserInfoExt callGetUserInfo(String token) throws Exception {
	log.info("Start WebServiceCall.callGetUserInfo method");

	String endpoint;
	Properties props;
	AuthenticateRequest authenticateRequest = new AuthenticateRequest(token);
	UserInfoResponse userInfoResponse = null;
	IntegraBDAPSoapProxy integraBDAPSoap = new IntegraBDAPSoapProxy();

	try {
	    props = getFileProperties("/properties/web_service.properties");
	    endpoint = props.getProperty("end_point");
	    integraBDAPSoap.setEndpoint(endpoint);
	    userInfoResponse = integraBDAPSoap.getUserInfo(authenticateRequest);
	} catch (Exception e) {
	    log.error("Exception invoked in method WebServiceCall.callGetUserInfo: " + e.toString());
	    throw e;
	}
	return userInfoResponse.getUserInfoExt();
    }

    public Properties getFileProperties(String path) throws Exception {
	log.info("Start WebServiceCall.getFileProperties method");

	Properties props = new Properties();
	File file = null;

	try {
	    file = new File(path);
	    file.createNewFile();
	    props.load(new FileInputStream(file));
	} catch (Exception e) {
	    log.error("Exception invoked in method WebServiceCall.getFileProperties: " + e.toString());
	    throw e;
	}
	return props;
    }
}
