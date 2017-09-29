/**
 * 
 */
package br.com.yurilemes.mysqlbackup.util;

import java.util.Collection;

/**
 * @author Yuri Lemes <yurilemes2@gmail.com>
 *
 */
public class Util {

	// Construtor privado
	private Util(){
	}
	
	/**
	 * Verifica se um objeto &eacute; vazio.
	 * 
	 * @param obj
	 * @return <b>true</b> se o objeto for vazio(empty).
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof Collection)
			return ((Collection<?>) obj).size() == 0;

		final String s = String.valueOf(obj).trim();

		return s.length() == 0 || s.equalsIgnoreCase("null");
	}
}
