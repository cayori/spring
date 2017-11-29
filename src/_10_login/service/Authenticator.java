package _10_login.service;

public interface Authenticator{
	void authenticate(LoginCommand loginCommand) throws AuthenticationException;
}
