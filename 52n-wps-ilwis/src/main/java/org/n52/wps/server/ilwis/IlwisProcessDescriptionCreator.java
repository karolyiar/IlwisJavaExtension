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

import java.math.BigInteger;

import net.opengis.ows.x11.DomainMetadataType;
import net.opengis.ows.x11.RangeType;
import net.opengis.wps.x100.ComplexDataCombinationsType;
import net.opengis.wps.x100.ComplexDataDescriptionType;
import net.opengis.wps.x100.InputDescriptionType;
import net.opengis.wps.x100.LiteralInputType;
import net.opengis.wps.x100.OutputDescriptionType;
import net.opengis.wps.x100.ProcessDescriptionType;
import net.opengis.wps.x100.ProcessDescriptionType.DataInputs;
import net.opengis.wps.x100.ProcessDescriptionType.ProcessOutputs;
import net.opengis.wps.x100.SupportedComplexDataInputType;

import org.n52.ilwis.java.IlwisOperation;
import org.n52.wps.io.IOHandler;

public class IlwisProcessDescriptionCreator {

	public ProcessDescriptionType createDescribeProcessType(IlwisOperation algorithm) throws UnsupportedGeoAlgorithmException{

			ProcessDescriptionType pdt = ProcessDescriptionType.Factory.newInstance();
			pdt.setStatusSupported(true);
			pdt.setStoreSupported(true);
			
			pdt.addNewAbstract().setStringValue(algorithm.getName());
			pdt.addNewTitle().setStringValue(algorithm.getLongname());
			pdt.addNewIdentifier().setStringValue(algorithm.getName());
			pdt.setProcessVersion("1.0.0");
			
			//inputs
			DataInputs inputs = pdt.addNewDataInputs();
			//ParametersSet params = algorithm.getParameters();
			for (int i = 1; algorithm.getPinType(i) != 0; i++) {
				//Parameter param = params.getParameter(i);
				addParameter(inputs, algorithm, i);
			}

			//outputs
			ProcessOutputs outputs = pdt.addNewProcessOutputs();
			for (int i = 0; algorithm.getPoutType(i) != 0; i++) {
				addOutput(outputs, algorithm, i);
			}

			return pdt;
	}

//	private void addGridExtent(DataInputs inputs, boolean bOptional){
//
//		addDoubleValue(inputs, GRID_EXTENT_X_MIN, "xMin", bOptional);
//		addDoubleValue(inputs, GRID_EXTENT_X_MAX, "xMax", bOptional);
//		addDoubleValue(inputs, GRID_EXTENT_Y_MIN, "yMin", bOptional);
//		addDoubleValue(inputs, GRID_EXTENT_Y_MAX, "yMax", bOptional);
//		addDoubleValue(inputs, GRID_EXTENT_CELLSIZE, "cellsize", bOptional);
//
//	}

//	private void addDoubleValue(DataInputs inputs, String name, String description, boolean bOptional){
//
//		int iMinOccurs = 1;
//
//		if (bOptional){
//			iMinOccurs = 0;
//		}
//
//		InputDescriptionType input = inputs.addNewInput();
//		input.addNewAbstract().setStringValue(description);
//		input.addNewTitle().setStringValue(description);
//		input.addNewIdentifier().setStringValue(name);
//
//		LiteralInputType literal = input.addNewLiteralData();
//		DomainMetadataType dataType = literal.addNewDataType();
//		dataType.setReference("xs:double");
//		literal.setDataType(dataType);
//		input.setMinOccurs(BigInteger.valueOf(iMinOccurs));
//		input.setMaxOccurs(BigInteger.valueOf(1));
//		literal.setDefaultValue("0");
//	}

	private void addOutput(ProcessOutputs outputs, IlwisOperation out, int index) {

		OutputDescriptionType output = outputs.addNewOutput();
		output.addNewAbstract().setStringValue(out.getLongname());
		output.addNewIdentifier().setStringValue(out.getName());
		output.addNewTitle().setStringValue(out.getLongname());
//		if (out instanceof OutputRasterLayer){
//			SupportedComplexDataType complexOutput = output.addNewComplexOutput();
//			complexOutput.addNewDefault().addNewFormat().setMimeType("image/tiff");
//			ComplexDataDescriptionType supportedFormat = complexOutput.addNewSupported().addNewFormat();
//			supportedFormat.setMimeType("image/tiff");
//			supportedFormat.setEncoding("base64");
//			
//			
//		}
//		else if (out instanceof OutputVectorLayer){
//			SupportedComplexDataType complexOutput = output.addNewComplexOutput();
//			addVectorOutputFormats(complexOutput);
//			/*ComplexDataDescriptionType deafult = complexOutput.addNewDefault().addNewFormat();
//			deafult.setMimeType(IOHandler.DEFAULT_MIMETYPE);
//			deafult.setSchema("http://geoserver.itc.nl:8080/wps/schemas/gml/2.1.2/gmlpacket.xsd");
//			ComplexDataCombinationsType supported = complexOutput.addNewSupported();
//			ComplexDataDescriptionType supportedFormat = supported.addNewFormat();
//			supportedFormat.setMimeType(IOHandler.DEFAULT_MIMETYPE);
//			supportedFormat.setSchema("http://schemas.opengis.net/gml/2.1.2/feature.xsd");
//			supportedFormat = supported.addNewFormat();
//			supportedFormat.setMimeType(IOHandler.MIME_TYPE_ZIPPED_SHP);
//			supportedFormat.setEncoding(IOHandler.ENCODING_BASE64);*/
//		}
//		else if (out instanceof OutputTable){
//			//TODO:
//		}
//		else if (out instanceof OutputText){
//			output.addNewComplexOutput().addNewDefault().addNewFormat().setMimeType("text/html");
//		}
//		else if (out instanceof OutputChart){
//			//TODO:
//		}


	}

	private void addParameter(DataInputs inputs, IlwisOperation ilwisOperaton, int index) throws UnsupportedGeoAlgorithmException {
		//MIME: application/octet-stream
		InputDescriptionType input = inputs.addNewInput();
		
		//input.addNewAbstract().setStringValue(param.getParameterDescription());
		input.addNewAbstract().setStringValue(ilwisOperaton.getPinDesc(index));
		
		//input.addNewTitle().setStringValue(param.getParameterDescription());
		input.addNewTitle().setStringValue(ilwisOperaton.getPinName(index));
		
		//input.addNewIdentifier().setStringValue(param.getParameterName());
		input.addNewIdentifier().setStringValue(ilwisOperaton.getPinName(index));
		
		long type = ilwisOperaton.getPinType(index);
		
		if (type == 17179869184L){ // Double
			LiteralInputType literal = input.addNewLiteralData();
			DomainMetadataType dataType = literal.addNewDataType();
			dataType.setReference("xs:double");
			literal.setDataType(dataType);
			input.setMinOccurs(BigInteger.valueOf(1));
			input.setMaxOccurs(BigInteger.valueOf(1));
			RangeType range = literal.addNewAllowedValues().addNewRange();
			range.addNewMaximumValue().setStringValue("" + Double.POSITIVE_INFINITY);
			range.addNewMinimumValue().setStringValue("" + Double.NEGATIVE_INFINITY);
//			literal.setDefaultValue(Double.toString(ai.getDefaultValue()));
		}
		else if (type == 68719476736L){ // String
			LiteralInputType literal = input.addNewLiteralData();
			input.setMinOccurs(BigInteger.valueOf(1));
			input.setMaxOccurs(BigInteger.valueOf(1));
			literal.addNewAnyValue();
			DomainMetadataType dataType = literal.addNewDataType();
			dataType.setReference("xs:string");
			literal.setDataType(dataType);
		}
		else if (true) { // File
			SupportedComplexDataInputType complex = input.addNewComplexData();
			ComplexDataCombinationsType supported = complex.addNewSupported();
			ComplexDataDescriptionType format = supported.addNewFormat();
			format.setMimeType("application/octet-stream");
			format.setEncoding(IOHandler.ENCODING_BASE64);
//			ComplexDataDescriptionType defaultFormat = complex.addNewDefault().addNewFormat();
			input.setMinOccurs(BigInteger.valueOf(1));
			input.setMaxOccurs(BigInteger.valueOf(1));
		}

	}

		
	//This class is thrown when there is any problem creating the XML
	//WPS file from a geoalgorithm, due to some yet unsupported feature
	//or parameter
	public class UnsupportedGeoAlgorithmException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1017100163300095362L;

	}

}


