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

package jhi.gwt.leaflet.client.layer.library;

import com.google.gwt.core.client.*;

import jhi.gwt.leaflet.client.basic.*;
import jhi.gwt.leaflet.client.layer.*;
import jhi.gwt.leaflet.client.map.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletHeatmap extends JavaScriptObject implements LeafletLayer
{
	protected LeafletHeatmap()
	{
	}

	/**
	 * Creates a {@link LeafletHeatmap} for the given map
	 *
	 * @return The newly created {@link LeafletHeatmap}
	 */
	public static LeafletHeatmap newInstance(LeafletMap map, Options options, JsArray<LeafletLatLng> data)
	{
		return createJso(map, options, data).cast();
	}

	private static native JavaScriptObject createJso(LeafletMap map, Options options, JsArray<LeafletLatLng> data) /*-{
		return $wnd.L.heatLayer(data, options).addTo(map);
	}-*/;

	public static class GradientOptions extends JavaScriptObject
	{
		protected GradientOptions()
		{
		}

		public static GradientOptions newInstance()
		{
			return createJso().cast();
		}

		private static native JavaScriptObject createJso()/*-{
			return {};
		}-*/;

		public native final void add(float value, String color)/*-{
			this[value] = color;
		}-*/;
	}

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
				minOpacity: 0.05,
				max: 1,
				radius: 25,
				blur: 15,
				gradient: {
					0.4: 'blue',
					0.6: 'cyan',
					0.7: 'lime',
					0.8: 'yellow',
					1.0: 'red'
				}
			};
		}-*/;

		public native final Options setGradient(GradientOptions gradient)/*-{
			this.gradient = gradient;
			return this;
		}-*/;

		public native final Options setMinOpacity(double minOpacity)/*-{
			this.minOpacity = minOpacity;
			return this;
		}-*/;

		public native final Options setMaxZoom(double maxZoom)/*-{
			this.maxZoom = maxZoom;
			return this;
		}-*/;

		public native final Options setMax(double max)/*-{
			this.max = max;
			return this;
		}-*/;

		public native final Options setRadius(int radius)/*-{
			this.radius = radius;
			return this;
		}-*/;

		public native final Options setBlur(int blur)/*-{
			this.blur = blur;
			return this;
		}-*/;
	}
}
