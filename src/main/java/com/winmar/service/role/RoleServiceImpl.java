package com.winmar.service.role;

import com.winmar.dao.BaseDao;
import com.winmar.dao.role.RoleDao;
import com.winmar.dao.role.RoleDaoImpl;
import com.winmar.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService{
	
	private RoleDao roleDao;
	
	public RoleServiceImpl(){
		roleDao = new RoleDaoImpl();
	}
	
	@Override
	public List<Role> getRoleList() {
		Connection connection = null;
		List<Role> roleList = null;
		try {
			connection = BaseDao.getConnection();
			roleList = roleDao.getRoleList(connection);
			if(roleList != null){
				System.out.println("ok");
			}else{
				System.out.println("notok");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return roleList;
	}
	
}