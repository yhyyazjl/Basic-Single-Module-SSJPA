package com.youmeek.ssm.module.user.dao;


import com.youmeek.ssm.module.user.pojo.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface SysUserDao extends JpaRepository<SysUser, Long> {
	
	SysUser findBySysUserId(Long sysUserId);
	
	SysUser findBySysUserLoginName(String sysUserLoginName);
	
	//使用了 Distinct 关键字 和 or 关键字
	List<SysUser> findDistinctSysUserBySysUserLoginNameOrSysUserId(String sysUserLoginName, Long sysUserId);
	
	//使用了 and 关键字
	List<SysUser> findSysUserBySysUserLoginNameAndSysUserId(String sysUserLoginName, Long sysUserId);
	
	
	// 使用了 Order by 进行排序（正序）
	List<SysUser> findBySysUserIsDeleteOrderBySysUserIdAsc(String sysUserIsDelete);
	
	// 使用了 Order by 进行排序（倒序）
	List<SysUser> findBySysUserIsDeleteOrderBySysUserIdDesc(String sysUserIsDelete);
	
	// 使用了 Top ，取出结果集的第一个，使用 First 也可以，效果一样
	SysUser findTopBySysUserIsDeleteOrderBySysUserIdDesc(String sysUserIsDelete);
	
	
	Page<SysUser> findBySysUserIsDeleteOrderBySysUserIdDesc(String sysUserIsDelete, Pageable pageable);
	
	List<SysUser> findBySysUserIsDelete(String sysUserIsDelete, Pageable pageable);
	List<SysUser> findBySysUserIsDelete(String sysUserIsDelete, Sort sort);
	
	// 使用了 Top 2，取出结果集的前2个，使用 First 也可以，效果一样
	List<SysUser> findTop2BySysUserIsDelete(String sysUserIsDelete, Sort sort);
	
	// 删除操作
	void deleteBySysUserId(Long sysUserId);
	
	//使用二级缓存
	@Query(value = "select u from SysUser u where u.sysUserIsDelete = ?1")
	@QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	List<SysUser> findIsNotDeleteUserListToTestEhCache(String sysUserIsDelete);
	
}  