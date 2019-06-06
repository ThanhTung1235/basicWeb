package com.basicWeb.model;

import com.basicWeb.entity.Member;
import com.basicWeb.utility.HandleString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberModel {

    public boolean register(Member member) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DBHelper.getConnection();
            String sqlString = "insert into  members (UserName,Email,Password,Address,Phone,Status,Salt) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, member.getUserName());
            preparedStatement.setString(2, member.getEmail());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getAddress());
            preparedStatement.setString(5, member.getPhone());
            preparedStatement.setInt(6, member.getStatus());
            preparedStatement.setString(7, member.getSalt());

            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Member authentication(String Username, Member.MemberStatus status) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DBHelper.getConnection();
            String sqlString = "select * from members where UserName = ? and Status = ?";
            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.setString(1, Username);
            statement.setInt(2, status.getValue());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String Name = resultSet.getString("UserName");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");
                String Address = resultSet.getString("Address");
                String Phone = resultSet.getString("Phone");
                int Status = resultSet.getInt("Status");
                String Salt = resultSet.getString("Salt");

                Member member = new Member();
                member.setUserName(Name);
                member.setEmail(Email);
                member.setPassword(Password);
                member.setAddress(Address);
                member.setPhone(Phone);
                member.setStatus(Member.MemberStatus.findByValue(Status));
                member.setSalt(Salt);
                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
//        Member member = authentication("Dr.Strange",Member.MemberStatus.DEACTIVE);
//        if (member != null){
//            System.out.println(member.getPassword());
//        }else {
//            System.out.println("not found");
//        }


    }
}
