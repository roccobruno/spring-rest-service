//package com.bruno.security;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import it.ddway.authentication.Item;
//import it.ddway.authentication.UserInfo;
//
//public class UserDetailsServiceImpl implements AuthenticationUserDetailsService<Authentication> {
//
//    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//
//    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
//
//	log.info("Start UserDetailsServiceImpl.loadUserDetails method");
//	String credentials = (String) token.getCredentials();
//	boolean principal = Boolean.valueOf(token.getPrincipal().toString());
//	WebServiceCall webServiceCall = new WebServiceCall();
//	UserInfo userInfo = new UserInfo();
//	String ruolo = null;
//	String cod_ente = "";
//	Item[] infoUtente = null;
//	User userDetails = null;
//
//	try {
//
//	    // userInfo = webServiceCall.callAuthenticate(credentials);
//	    // infoUtente = userInfo.getAttributes();
//	    // for (int i = 0; i < infoUtente.length; i++) {
//	    // if(infoUtente[i].getKey().equalsIgnoreCase("OP_PROFILO")){
//	    // ruolo = infoUtente[i].getValue();
//	    //// System.out.println("Ruolo: "+ruolo);
//	    // }else if(infoUtente[i].getKey().equalsIgnoreCase("OP_ENTE")){
//	    // cod_ente = infoUtente[i].getValue();
//	    // userInfo.setName(userInfo.getName()+"_"+cod_ente+"_"+credentials);
//	    //// System.out.println("Codice ente: "+cod_ente);
//	    // }
//	    // }
//
//	    userInfo.setName("Giovanni Bruno");
//	    ruolo = "RP";
//
//	    if (ruolo != null) {
//		if (ruolo.equalsIgnoreCase("UB")) {
//		    userDetails = getBaseUser(userInfo);
//		} else if (ruolo.equalsIgnoreCase("RP")) {
//		    userDetails = getValidatorUser(userInfo);
//		} else if (ruolo.equalsIgnoreCase("HD")) {
//		    userDetails = getHelpdeskUser(userInfo);
//		}
//	    }
//	    if (userDetails == null) {
//		throw new UsernameNotFoundException("Could not load user : ruolo is " + ruolo);
//	    }
//	} catch (RemoteException re) {
//	    log.error("RemoteException invoked in method UserDetailsServiceImpl.loadUserDetails: " + re.toString());
//	} catch (FileNotFoundException fnfe) {
//	    log.error("FileNotFoundException invoked in method UserDetailsServiceImpl.loadUserDetails: " + fnfe.toString());
//	} catch (IOException ioe) {
//	    log.error("IOException invoked in method UserDetailsServiceImpl.loadUserDetails: " + ioe.toString());
//	} catch (Exception e) {
//	    log.error("Exception invoked in method UserDetailsServiceImpl.loadUserDetails: " + e.toString());
//	}
//	return userDetails;
//    }
//
//    private User getValidatorUser(UserInfo user) throws Exception {
//	log.info("Start UserDetailsServiceImpl.getValidatorUser method");
//
//	Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//
//	try {
//	    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_VALIDATOR"));
//	    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//	    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_HELPDESK"));
//	} catch (Exception e) {
//	    log.error("Exception invoked in method UserDetailsServiceImpl.getValidatorUser: " + e.toString());
//	    throw e;
//	}
//	return new User(user.getName(), "notused", true, true, true, true, grantedAuthorities);
//    }
//
//    private User getBaseUser(UserInfo user) throws Exception {
//
//	log.info("Start UserDetailsServiceImpl.getBaseUser method");
//	Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//
//	try {
//	    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//	    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_HELPDESK"));
//	} catch (Exception e) {
//	    log.error("Exception invoked in method UserDetailsServiceImpl.getBaseUser: " + e.toString());
//	    throw e;
//	}
//	return new User(user.getName(), "notused", true, true, true, true, grantedAuthorities);
//    }
//
//    private User getHelpdeskUser(UserInfo user) throws Exception {
//
//	log.info("Start UserDetailsServiceImpl.getHelpdeskUser method");
//	Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//
//	try {
//	    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_HELPDESK"));
//	} catch (Exception e) {
//	    log.error("Exception invoked in method UserDetailsServiceImpl.getHelpdeskUser: " + e.toString());
//	    throw e;
//	}
//	return new User(user.getName(), "notused", true, true, true, true, grantedAuthorities);
//    }
//}
