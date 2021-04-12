package main.Api.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserListResponse {
    private boolean result;
    private ArrayList<LoginUserResponse> users;
    private String error;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public ArrayList<LoginUserResponse> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<LoginUserResponse> users) {
        this.users = users;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
