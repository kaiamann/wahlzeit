/*
 * CarPhotoManager
 *
 * Version 1.0
 *
 * 12.11.2017
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

package org.wahlzeit.model;

import java.util.logging.Logger;

public class CarPhotoManager extends PhotoManager {
	
	protected static final CarPhotoManager instance = new CarPhotoManager();
	
	private static final Logger log = Logger.getLogger(CarPhotoManager.class.getName());

	public CarPhotoManager() {
		photoTagCollector = CarPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	public static synchronized CarPhotoManager getInstance() {
		return instance;
	}
	
	

}
