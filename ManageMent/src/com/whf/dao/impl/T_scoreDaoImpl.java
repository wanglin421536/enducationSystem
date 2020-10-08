package com.whf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.whf.dao.T_scoreDao;
import com.whf.pojo.Course;
import com.whf.pojo.T_score;
import com.whf.util.JdbcUtils;

public class T_scoreDaoImpl implements T_scoreDao {

	@Override
	public List<T_score> T_score_query() {
		String sql="SELECT score,studentId,subjectId FROM t_scoer";
		
		List<T_score> list =new ArrayList<T_score>();
		try {
			Connection  conn=JdbcUtils.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				//遍历查询到的结果集并创建Course对象
				int score=rs.getInt("score");
				int studentId=rs.getInt("studentId");
				int subjectId=rs.getInt("subjectId");
				T_score tscore=new T_score(score,studentId,subjectId);
				//将查询的对象存入集合中
				list.add(tscore);
			    conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
		
	@Override
	public List<T_score> T_score_update(T_score score) {
		return null;
	}	
}
