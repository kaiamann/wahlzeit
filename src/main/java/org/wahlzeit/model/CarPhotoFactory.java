/*
 * CarPhotoFactory
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

import org.wahlzeit.services.LogBuilder;

public class CarPhotoFactory extends PhotoFactory {

	protected CarPhotoFactory() {
		// do nothing
	}

	private static final Logger log = Logger.getLogger(CarPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static CarPhotoFactory instance = null;


	/**
	 * Public singleton access method.
	 */
	public static synchronized CarPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting CarPhotoFactory").toString());
			setInstance(new CarPhotoFactory());
		}
		return instance;
	}


	public Photo createPhoto() {
		return new CarPhoto();
	}
	

	public Photo createPhoto(PhotoId id) {
		return new CarPhoto(id);
	}
	
	
	
	

}
