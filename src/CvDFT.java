/*
 * This file is part of the LIRE project: http://lire-project.net
 * LIRE is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * LIRE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LIRE; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * We kindly ask you to refer the any or one of the following publications in
 * any publication mentioning or employing Lire:
 *
 * Lux Mathias, Savvas A. Chatzichristofis. Lire: Lucene Image Retrieval -
 * An Extensible Java CBIR Library. In proceedings of the 16th ACM International
 * Conference on Multimedia, pp. 1085-1088, Vancouver, Canada, 2008
 * URL: http://doi.acm.org/10.1145/1459359.1459577
 *
 * Lux Mathias. Content Based Image Retrieval with LIRE. In proceedings of the
 * 19th ACM International Conference on Multimedia, pp. 735-738, Scottsdale,
 * Arizona, USA, 2011
 * URL: http://dl.acm.org/citation.cfm?id=2072432
 *
 * Mathias Lux, Oge Marques. Visual Information Retrieval using Java and LIRE
 * Morgan & Claypool, 2013
 * URL: http://www.morganclaypool.com/doi/abs/10.2200/S00468ED1V01Y201301ICR025
 */

package net.semanticmetadata.lire.imageanalysis.features.global;


import net.semanticmetadata.lire.builders.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.GlobalFeature;
import net.semanticmetadata.lire.imageanalysis.features.LireFeature;

import java.awt.image.BufferedImage;

/**
 * Discrete Fourier Transform of an image comprising amplitude and phase spectrum.
 * @author:
 * The DFT feature was implemented using the OpenCV library.
 *
 * License Agreement
 * For Open Source Computer Vision Library
 * (3-clause BSD License)
 *
 * Copyright (C) 2000-2019, Intel Corporation, all rights reserved.
 * Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
 * Copyright (C) 2009-2016, NVIDIA Corporation, all rights reserved.
 * Copyright (C) 2010-2013, Advanced Micro Devices, Inc., all rights reserved.
 * Copyright (C) 2015-2016, OpenCV Foundation, all rights reserved.
 * Copyright (C) 2015-2016, Itseez Inc., all rights reserved.
 * Third party copyrights are property of their respective owners.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 *     disclaimer.
 *     Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 *     disclaimer in the documentation and/or other materials provided with the distribution.
 *     Neither the names of the copyright holders nor the names of the contributors may be used to endorse or promote
 *     products derived from this software without specific prior written permission.
 *
 * This software is provided by the copyright holders and contributors “as is” and any express or implied warranties,
 * including, but not limited to, the implied warranties of merchantability and fitness for a particular purpose are
 * disclaimed. In no event shall copyright holders or contributors be liable for any direct, indirect, incidental,
 * special, exemplary, or consequential damages (including, but not limited to, procurement of substitute goods or services;
 * loss of use, data, or profits; or business interruption) however caused and on any theory of liability, whether in contract,
 * strict liability, or tort (including negligence or otherwise) arising in any way out of the use of this software, even
 * if advised of the possibility of such damage.
 */

public class CvDFT implements GlobalFeature{

    //feature storage
    protected double[] frequency;
    protected final int frequency_offset = 0;
    protected double[] magnitude;
    protected final int magnitude_offset; //set something meaningful here
    protected double[] phase;
    protected final int phase_offset; //set something meaningful here

    //no parameters must be defined
    public CvDFT(){
        super();
    }

    //from LireFeature:
    @Override
    public String getFeatureName(){
        return "CvDFT";
    }

    public String getFieldName(){
        return DocumentBuilder.FIELD_NAME_OPENCVDFT;
    }

    public byte[] getByteArrayRepresentation(){
        int length; //define meaningful length
        byte[] result = new byte[length];
        // fill the array
        encodeFeature(frequency, result, frequency_offset);
        encodeFeature(magnitude, result, magnitude_offset);
        encodeFeature(phase, result, phase_offset);
        return result;
    }

    protected void encodeFeature(double[] feature, byte[] target, int offset){
        //transform part feature values to a byte array representation
        //use offset to determine target part of the vector
        //assuming the double values can be transformed uniformly across frequency/magnitude/phase
    }

    protected double[] restoreFeature(byte[] in_rep, int offset, int length){
        //restore part feature values from the byte array representation
        //use offset to retrieve requested part feature from whole vector
        //assuming the double values have been transformed uniformly across frequency/magnitude/phase
    }

    public void setByteArrayRepresentation(byte[] in_rep){
        //find out length of feature vector
        int length;
        //restore feature values from the byte array representation
        frequency = restoreFeature(in_rep, frequency_offset, length);
        magnitude = restoreFeature(in_rep, magnitude_offset, length);
        phase = restoreFeature(in_rep, phase_offset, length);
    }

    public void setByteArrayRepresentation(byte[] in_rep, int offset, int length){
        //restore feature values from the byte array representation
        frequency = restoreFeature(in_rep, offset+frequency_offset, length);
        magnitude = restoreFeature(in_rep, offset+magnitude_offset, length);
        phase = restoreFeature(in_rep, offset+phase_offset, length);
    }

    public double getDistance(LireFeature var1){
        if (!(vd instanceof CvDFT))
            throw new UnsupportedOperationException("Wrong descriptor.");

        // casting ...
        tmpFeature = (CvDFT) vd;

        //compute distance
        // frequencies are used to make two spectra comparable, if they are not equal: build histogramd with equivalent bins
        // compute the distance of magnitude and phase spectrum from cross correlation of the two signals=images
        // to obtain a single value, compute integral of absolute value of cross correlation and invert it (1/integral)
        float result = 100;
        return result;
    }

    //from FeatureVector:
    public double[] getFeatureVector(){
        double[] featurevec;
        //fill the feature vector appending frequency, magnitude and phase spectrum
        return featurevec;
    }

    //from Extractor:
    public void extract(BufferedImage img){
        //convert img into a format compatible with openCV
        //retrieve DFT from openCV
        //isolate frequency from DFT
        //according to number of frequencies, determine length of magnitude and phase arrays
        //fill magnitude and phase arrays from openCV DFT
    }

    //misc:
    public String toString(){
        String str;
        // fill str with information about the spectra
        return str;
    }
}