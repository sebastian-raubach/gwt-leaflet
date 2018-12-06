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
public class LeafletPruneCluster extends JavaScriptObject implements LeafletLayer
{
	protected LeafletPruneCluster()
	{
	}

	/**
	 * Creates a {@link LeafletPruneCluster} for the given map
	 *
	 * @return The newly created {@link LeafletPruneCluster}
	 */
	public static LeafletPruneCluster newInstance(LeafletMap map)
	{
		return createJso(map).cast();
	}

	private static native JavaScriptObject createJso(LeafletMap map) /*-{
		var c = new $wnd.PruneClusterForLeaflet();

		map.addLayer(c);

		return c;
	}-*/;

	public native final LeafletPruneCluster registerMarker(LeafletPruneMarker marker)/*-{
		this.RegisterMarker(marker);
	}-*/;

	public native final void removeMarkers()/*-{
		this.RemoveMarkers();
	}-*/;

	public native final void processView()/*-{
		this.ProcessView();
	}-*/;
}
