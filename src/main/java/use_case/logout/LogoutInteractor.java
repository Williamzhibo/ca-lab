package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        // Get the current username before we clear it
        String username = userDataAccessObject.getCurrentUsername();
        
        // Clear the current user in the DAO
        userDataAccessObject.setCurrentUsername(null);
        
        // Create the output data with the username of the user that just logged out
        LogoutOutputData logoutOutputData = new LogoutOutputData(username);
        
        // Tell the presenter to prepare the success view
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}

