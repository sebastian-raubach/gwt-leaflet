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
public class LeafletClusterer extends JavaScriptObject implements LeafletLayer
{
	protected LeafletClusterer()
	{
	}

	/**
	 * Creates a {@link LeafletClusterer} for the given map
	 *
	 * @return The newly created {@link LeafletClusterer}
	 */
	public static LeafletClusterer newInstance(LeafletMap map, Options options)
	{
		return createJso(map, options).cast();
	}

	private static native JavaScriptObject createJso(LeafletMap map, Options options) /*-{
		var c = new $wnd.L.markerClusterGroup(options);

		map.addLayer(c);

		return c;
	}-*/;

	public final native void clearLayers()/*-{
		this.clearLayers();
	}-*/;

	public final native void addMarker(LeafletMarker m)/*-{
		this.addLayer(m);
	}-*/;

	public final native void addMarkers(JsArray<LeafletMarker> ms) /*-{
		this.addLayers(ms);
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
				showCoverageOnHover: true,
				zoomToBoundsOnClick: true,
				spiderfyOnMaxZoom: true,
				removeOutsideVisibleBounds: true,
				animate: true,
				animateAddingMarkers: false,
				maxClusterRadius: 80,
				singleMarkerMode: false,
				spiderfyDistanceMultiplier: 1
			};
		}-*/;

		public native final Options setShowCoverageOnHover(boolean showCoverageOnHover)/*-{
			this.showCoverageOnHover = showCoverageOnHover;
			return this;
		}-*/;

		public native final Options setZoomToBoundsOnClick(boolean zoomToBoundsOnClick)/*-{
			this.zoomToBoundsOnClick = zoomToBoundsOnClick;
			return this;
		}-*/;

		public native final Options setSpiderfyOnMaxZoom(boolean spiderfyOnMaxZoom)/*-{
			this.spiderfyOnMaxZoom = spiderfyOnMaxZoom;
			return this;
		}-*/;

		public native final Options setRemoveOutsideVisibleBounds(boolean removeOutsideVisibleBounds)/*-{
			this.removeOutsideVisibleBounds = removeOutsideVisibleBounds;
			return this;
		}-*/;

		public native final Options setAnimate(boolean animate)/*-{
			this.animate = animate;
			return this;
		}-*/;

		public native final Options setAnimateAddingMarkers(boolean animateAddingMarkers)/*-{
			this.animateAddingMarkers = animateAddingMarkers;
			return this;
		}-*/;

		public native final Options setDisableClusteringAtZoom(int disableClusteringAtZoom)/*-{
			this.disableClusteringAtZoom = disableClusteringAtZoom;
			return this;
		}-*/;

		public native final Options setMaxClusterRadius(int maxClusterRadius)/*-{
			this.maxClusterRadius = maxClusterRadius;
			return this;
		}-*/;

		public native final Options setSingleMarkerMode(boolean singleMarkerMode)/*-{
			this.singleMarkerMode = singleMarkerMode;
			return this;
		}-*/;

		public native final Options setSpiderfyDistanceMultiplier(int spiderfyDistanceMultiplier)/*-{
			this.spiderfyDistanceMultiplier = spiderfyDistanceMultiplier;
			return this;
		}-*/;
	}
}
