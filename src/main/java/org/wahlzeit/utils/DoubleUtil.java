/*
 * DoubleUtil
 *
 * Version 1.0
 *
 * 03.12.2017
 *
 * Copyright (c) 2107 by Kai Amann, https://github.com/kaiamann
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.utils;

public class DoubleUtil {
	/**
	 * EPSILON for compensating floating point errors
	 */
	private static final double EPSILON = 1e-6;

	public static boolean isEqual(double d1, double d2) {
		double dif = Math.abs(d1 - d2);

		if(dif < EPSILON) {
			return true;
		}
		return false;
	}
}
