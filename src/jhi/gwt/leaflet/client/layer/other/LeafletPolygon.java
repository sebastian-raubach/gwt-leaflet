/*
 *  Copyright 2018 Sebastian Raubach from the Information
 *  and Computational Sciences Group at JHI Dundee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package jhi.gwt.leaflet.client.layer.other;

import com.google.gwt.core.client.*;

import jhi.gwt.leaflet.client.layer.*;
import jhi.gwt.leaflet.client.map.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletPolygon extends JavaScriptObject implements LeafletLayer
{
	protected LeafletPolygon()
	{
	}

	public static LeafletPolygon newInstance(JsArray<JsArrayNumber> points, Options options)
	{
		return createJso(points, options).cast();
	}

	private static native JavaScriptObject createJso(JsArray<JsArrayNumber> points, Options options) /*-{
		return $wnd.L.polygon([points], options);
	}-*/;

	public final native LeafletPolygon addTo(LeafletMap map) /*-{
		this.addTo(map);
		return this;
	}-*/;

	public static class Options extends JavaScriptObject
	{
		protected Options()
		{
		}

		public static Options newInstance()
		{
			return createJso().cast();
		}

		private static native JavaScriptObject createJso() /*-{
			return {
				color: "#00acef",
				fillColor: "#00acef",
				fillOpacity: 0.2
			};
		}-*/;

		public native final Options setColor(String color)/*-{
			this.color = color;
			return this;
		}-*/;

		public native final Options setFillColor(String fillColor)/*-{
			this.fillColor = fillColor;
			return this;
		}-*/;

		public native final Options setFillOpacity(Double fillOpacity)/*-{
			this.fillOpacity = fillOpacity;
			return this;
		}-*/;
	}
}
