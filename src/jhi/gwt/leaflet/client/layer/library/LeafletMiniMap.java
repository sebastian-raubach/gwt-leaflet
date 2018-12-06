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
import jhi.gwt.leaflet.client.control.*;
import jhi.gwt.leaflet.client.layer.*;
import jhi.gwt.leaflet.client.map.*;

/**
 * @author Sebastian Raubach
 */
public class LeafletMiniMap extends JavaScriptObject implements LeafletLayer
{
	protected LeafletMiniMap()
	{
	}

	/**
	 * Creates a {@link LeafletMiniMap} for the given map
	 *
	 * @return The newly created {@link LeafletMiniMap}
	 */
	public static LeafletMiniMap newInstance(LeafletMap parent)
	{
		return createJso(parent, null).cast();
	}

	public static LeafletMiniMap newInstance(LeafletMap parent, Options options)
	{
		return createJso(parent, options).cast();
	}

	private static native JavaScriptObject createJso(LeafletMap parent, Options options) /*-{
		var osm = $wnd.L.tileLayer('//{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>',
			subdomains: ['a', 'b', 'c']
		});

		var result = new $wnd.L.Control.MiniMap(osm, options);

		parent.on("resize", function () {
			result._miniMap.invalidateSize();
		});

		result.addTo(parent);

		return result;
	}-*/;

	public static class Options extends JavaScriptObject
	{
		protected Options()
		{
		}

		/**
		 * Creates a {@link Options} for the given map
		 *
		 * @return The newly created {@link Options}
		 */
		public static Options newInstance()
		{
			return createJso().cast();
		}

		private static native JavaScriptObject createJso() /*-{
			return {
				position: "bottomright",
				width: 150,
				height: 150,
				collapsedWidth: 19,
				collapsedHeight: 19,
				zoomLevelOffset: -5,
				zoomLevelFixed: -5,
				centerFixed: false,
				zoomAnimation: false,
				toggleDisplay: false,
				autoToggleDisplay: false,
				minimized: false
			};
		}-*/;

		public final Options setPosition(LeafletControlPosition position)
		{
			return setPosition(position.getPosition());
		}

		private native Options setPosition(String position)/*-{
			this.position = position;
			return this;
		}-*/;

		public native final Options setWidth(int width)/*-{
			this.width = width;
			return this;
		}-*/;

		public native final Options setHeight(int height)/*-{
			this.height = height;
			return this;
		}-*/;

		public native final Options setCollapsedWidth(int collapsedWidth)/*-{
			this.collapsedWidth = collapsedWidth;
			return this;
		}-*/;

		public native final Options setCollapsedHeight(int collapsedHeight)/*-{
			this.collapsedHeight = collapsedHeight;
			return this;
		}-*/;

		public native final Options setZoomLevelOffset(int zoomLevelOffset)/*-{
			this.zoomLevelOffset = zoomLevelOffset;
			return this;
		}-*/;

		public native final Options setZoomLevelFixed(int zoomLevelFixed)/*-{
			this.zoomLevelFixed = zoomLevelFixed;
			return this;
		}-*/;

		public native final Options setCenterFixed(boolean centerFixed)/*-{
			this.centerFixed = centerFixed;
			return this;
		}-*/;

		public native final Options setCenterFixed(LeafletLatLng centerFixed)/*-{
			this.centerFixed = centerFixed;
			return this;
		}-*/;

		public native final Options setZoomAnimation(boolean zoomAnimation)/*-{
			this.zoomAnimation = zoomAnimation;
			return this;
		}-*/;

		public native final Options setToggleDisplay(boolean toggleDisplay)/*-{
			this.toggleDisplay = toggleDisplay;
			return this;
		}-*/;

		public native final Options setAutoToggleDisplay(boolean autoToggleDisplay)/*-{
			this.autoToggleDisplay = autoToggleDisplay;
			return this;
		}-*/;

		public native final Options setMinimized(boolean minimized)/*-{
			this.minimized = minimized;
			return this;
		}-*/;
	}
}