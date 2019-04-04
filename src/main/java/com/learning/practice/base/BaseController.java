package com.learning.practice.base;

import com.learning.practice.utils.Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
 * 控制层基础类
 * 
 * @author zhonghui
 *
 * @param <T>
 * @param <K>
 */
public abstract class BaseController<T extends IEntity, K> {

	protected Log logger = LogFactory.getLog(getClass());

	protected abstract String getTemplateFolder();

	@RequestMapping(value = "/")
	public String index() {
		return getTemplateFolder() + "/index";
	}

	protected abstract IService<T, K> getService();

	private Class<?> persistentClass;
	@Autowired
	protected Environment env;

	public Class<?> getPersistentClass() {
		return this.persistentClass;
	}

	public BaseController() {
		this.persistentClass = (Class<?>) Helper.getSuperClassGenricType(getClass(), 0);
		Assert.notNull(persistentClass);
	}

	@ResponseBody
	@RequestMapping("/list")
	public PageResult<T> selectByPage(Map<String, Object> params, Pagenation page) {

		long total = page.getTotal();
		if (total <= 0) {
			total = getService().selectCount(params);
		}
		List<T> rows = getService().selectByPage(params, page);
		return new PageResult<T>(rows, total);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public T create(T entry) {
		getService().insert(entry);
		return entry;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public T update(T entry) throws Exception {
		try {
			getService().update(entry);
			return entry;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * user/delete/1
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
	public Integer deleteByPrimaryKey(@PathVariable("id") K id) {
		return getService().deleteByPrimaryKey(id);
	}

}
