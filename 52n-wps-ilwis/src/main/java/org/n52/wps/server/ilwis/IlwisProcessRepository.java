/**
 * ﻿Copyright (C) 2007 - 2014 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *       • Apache License, version 2.0
 *       • Apache Software License, version 1.0
 *       • GNU Lesser General Public License, version 3
 *       • Mozilla Public License, versions 1.0, 1.1 and 2.0
 *       • Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.wps.server.ilwis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.opengis.wps.x100.ProcessDescriptionType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.xmlbeans.XmlException;
import org.n52.ilwis.java.Engine;
import org.n52.ilwis.java.IlwisOperation;
import org.n52.ilwis.java.ilwisobjects;
import org.n52.ilwis.java.vectorOperation;
import org.n52.wps.PropertyDocument.Property;
import org.n52.wps.commons.WPSConfig;
import org.n52.wps.server.IAlgorithm;
import org.n52.wps.server.IAlgorithmRepository;

/*
 * A container, which allows the 52n WPS to recognize the Ilwis library.
 * Basic initialization is performed here.
 * 
 * Whenever a getcapabilities request comes in, the process names are extraced based on the available process description documents for sextante processes.
 * This should be changed in the future, when process descriptions should be generated automatically. When a execute process request comes in, a generic GenericIlwisProcessDelegator is created. 
 */

public class IlwisProcessRepository implements IAlgorithmRepository {
	private static Logger LOGGER = LoggerFactory
			.getLogger(IlwisProcessRepository.class);
	private Map<String, ProcessDescriptionType> registeredProcesses;

	@Override
	public Collection<String> getAlgorithmNames() {
		return registeredProcesses.keySet();
	}

	@Override
	public IAlgorithm getAlgorithm(String processID) {
		if (!containsAlgorithm(processID)) {
			throw new RuntimeException("Could not allocate Process");
		}
		return new GenericIlwisProcessDelegator(processID,
				registeredProcesses.get(processID));
	}

	@Override
	public ProcessDescriptionType getProcessDescription(String processID) {
		if (!registeredProcesses.containsKey(processID)) {
			registeredProcesses.put(processID, getAlgorithm(processID)
					.getDescription());
		}
		return registeredProcesses.get(processID);
	}

	public boolean containsAlgorithm(String processID) {
		if (registeredProcesses.containsKey(processID)) {
			return true;
		}
		LOGGER.warn("Could not find Ilwis Process " + processID);
		return false;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	public IlwisProcessRepository() {
		LOGGER.info("Initializing Ilwis Repository");
		registeredProcesses = new HashMap<String, ProcessDescriptionType>();

		/*
		 * get properties of Repository
		 * 
		 * check whether process is amongst them and active
		 * 
		 * if properties are empty (not initialized yet) add all valid processes
		 * to WPSConfig
		 */

		Property[] propertyProcesses = WPSConfig.getInstance()
				.getPropertiesForRepositoryClass(this.getClass().getName());

		ArrayList<String> processList = new ArrayList<String>(
				propertyProcesses.length);

		for (Property prop : propertyProcesses) {

			if (prop.getActive()) {
				processList.add(prop.getStringValue());
			} else {
				LOGGER.info("Ilwis Process : " + prop.getStringValue()
						+ " not active.");
			}
		}

		// Ilwis initialize
		LOGGER.info("before loading ilwis");
		try {
			ilwisobjects.initIlwisObjects(ilwisobjects.ilwisLocation);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("after loading ilwis");
		// HashMap<String, HashMap<String, GeoAlgorithm>> sextanteMap =
		// Sextante.getAlgorithms();
		// HashMap<String, GeoAlgorithm> algorithmMap =
		// sextanteMap.get("SEXTANTE");
		// Set<String> keys = algorithmMap.keySet();
		// SextanteProcessDescriptionCreator descriptionCreator = new
		// SextanteProcessDescriptionCreator();
		// vectorOperation ilwisOperations = Engine.getAllOperations();
		// IlwisProcessDescriptionCreator descriptionCreator = new
		// IlwisProcessDescriptionCreator();
		//
		// for (int i = 0; i < ilwisOperations.size(); i++) {
		// // String key = Long.toString( ilwisOperations.get(i).getId() );
		// long id = ilwisOperations.get(i).getId();
		// // if(!processList.contains(key)){
		// if (!processList.contains(Long.toString(id))) {
		// LOGGER.info("Did not add Ilwis Process : " + id
		// + ". Not in Repository properties or not active.");
		// continue;
		// }
		// IlwisOperation ilwisProcess = Engine.getOperationById(id);
		// ProcessDescriptionType processDescription;
		// try {
		// processDescription = descriptionCreator
		// .createDescribeProcessType(ilwisProcess);
		// } catch (Exception e) {
		// LOGGER.warn("Could not add Ilwis Process : " + id
		// + ". Errors while creating describe Process");
		// continue;
		// }
		//
		// registeredProcesses.put(Long.toString(id), processDescription);
		// LOGGER.info("Ilwis Process " + Long.toString(id) + " added.");
		// }

		LOGGER.info("Initialization of Ilwis Repository successful");
	}
	//
	//
	// /*public boolean addAlgorithm(Object describeProcess) {
	// String processName = "";
	// ProcessDescriptionType document = null;
	// try {
	// if(describeProcess instanceof File){
	//
	// document = ProcessDescriptionType.Factory.parse((File)describeProcess);
	// }
	// if(describeProcess instanceof ProcessDescriptionType){
	// document = (ProcessDescriptionType) describeProcess;
	// }
	//
	//
	// } catch (IOException e) {
	// LOGGER.warn("Could not add Sextante Extension Process. Identifier: Unknown",
	// e);
	// e.printStackTrace();
	// } catch (XmlException e) {
	// e.printStackTrace();
	// }
	// if(describeProcess == null){
	// throw new RuntimeException("Could not add process");
	// }
	//
	//
	// registeredProcesses.put(document.getIdentifier().getStringValue(),
	// document);
	//
	// LOGGER.info("Sextante Extension Process "+ processName +
	// " added successfully");
	// return true;
	//
	// }*/
	//
	// public boolean removeAlgorithm(Object className) {
	// //not implemented
	// return false;
	// }

}
