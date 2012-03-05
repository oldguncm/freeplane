package org.docear.plugin.core.listeners;

import java.io.File;

import org.docear.plugin.core.DocearController;
import org.docear.plugin.core.logger.DocearLogEvent;
import org.freeplane.features.map.IMapLifeCycleListener;
import org.freeplane.features.map.MapModel;
import org.freeplane.features.map.mindmapmode.MMapModel;

public class MapLifeCycleListener implements IMapLifeCycleListener {

	public void onCreate(MapModel map) {
		if (map instanceof MMapModel) {
			File f = map.getFile();
			if (f!=null) {
				DocearController.getController().getDocearEventLogger().write(this, DocearLogEvent.MAP_OPENED, f);
			}
			else {
				//if (map. == null) {
					DocearController.getController().getDocearEventLogger().write(this, DocearLogEvent.MAP_NEW);
				//}
			}
		}
	}

	public void onRemove(MapModel map) {
		if (map instanceof MMapModel) {
			File f = map.getFile();
			if (f!=null) {
				DocearController.getController().getDocearEventLogger().write(this, DocearLogEvent.MAP_CLOSED, f);
			}
		}
	}

	public void onSavedAs(MapModel map) {
		if (map instanceof MMapModel) {
			File f = map.getFile();
			if (f!=null) {
				DocearController.getController().getDocearEventLogger().write(this, DocearLogEvent.MAP_SAVED, f);
			}
		}
	}

	public void onSaved(MapModel map) {
		if (map instanceof MMapModel) {
			File f = map.getFile();
			if (f!=null) {
				DocearController.getController().getDocearEventLogger().write(this, DocearLogEvent.MAP_SAVED, f);
			}
		}
	}

}
