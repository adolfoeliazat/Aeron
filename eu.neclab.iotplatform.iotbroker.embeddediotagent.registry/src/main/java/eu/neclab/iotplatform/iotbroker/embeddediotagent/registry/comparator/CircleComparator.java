/*******************************************************************************
 *   Copyright (c) 2015, NEC Europe Ltd.
 *   All rights reserved.
 *
 *   Authors:
 *           * Salvatore Longo - salvatore.longo@neclab.eu
 *           * Tobias Jacobs - tobias.jacobs@neclab.eu
 *           * Flavio Cirillo - flavio.cirillo@neclab.eu
 *
 *    Redistribution and use in source and binary forms, with or without
 *    modification, are permitted provided that the following conditions are met:
 *   1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   3. All advertising materials mentioning features or use of this software
 *     must display the following acknowledgment:
 *     This product includes software developed by NEC Europe Ltd.
 *   4. Neither the name of NEC nor the names of its contributors may be used
 *   to endorse or promote products derived from this software without specific 
 *   prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY NEC ''AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL NEC BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/

package eu.neclab.iotplatform.iotbroker.embeddediotagent.registry.comparator;

import java.util.Comparator;

import eu.neclab.iotplatform.ngsi.api.datamodel.Circle;

/**
 * @author Flavio Cirillo (flavio.cirillo@neclab.eu)
 *
 */
public class CircleComparator implements Comparator<Circle> {


	private static final float epsilon = 0.0000000001f;
	
	@Override
	/**
	 * The order of the Segment objects takes into account, in order:
	 * Radius -> Center_Latitude -> Center_Longitude
	 * 
	 * Null object is order before a not-null object.
	 * 
	 */
	public int compare(Circle o1, Circle o2) {
		if (o1 == o2) {
			return 0;
		} else if (o1 == null) {
			return -1;
		} else if (o2 == null) {
			return 1;
		}
		
		if(Math.abs(o1.getRadius() - o2.getRadius()) > epsilon){
			return Float.compare(o1.getRadius(), o2.getRadius());
		}
		
		if(Math.abs(o1.getCenterLatitude() - o2.getCenterLatitude()) > epsilon){
			return Float.compare(o1.getCenterLatitude(), o2.getCenterLatitude());
		}
	
		if(Math.abs(o1.getCenterLongitude() - o2.getCenterLongitude()) > epsilon){
			return Float.compare(o1.getCenterLongitude(), o2.getCenterLongitude());
		}
		
		return 0;
	}

}
