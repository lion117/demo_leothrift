namespace java example.project

struct User_data{
1: required string username
2: required string password
}


service Login {
string Login_in(1:User_data t_user)
i32   Query(1:string t_ID , 2:string t_data)
i32   Login_out(1:string t_ID)
}