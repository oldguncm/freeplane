package org.freeplane.plugin.collaboration.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class UpdatesEventCaptor implements UpdatesProcessor {
	private final CountDownLatch lock;
	private ArrayList<UpdatesFinished> events;

	UpdatesEventCaptor(int expectedEventCount) {
		this.lock = new CountDownLatch(expectedEventCount);
		events = new ArrayList<>();
	}

	@Override
	public void onUpdates(UpdatesFinished event) {
		events.add(event);
		assertThat(lock.getCount() > 0);
		lock.countDown();
	}

	public List<UpdatesFinished> getEvents(long timeout, TimeUnit unit)  throws InterruptedException {
		await(timeout, unit);
		return events;
	}

	public UpdatesFinished getEvent(long timeout, TimeUnit unit)  throws InterruptedException {
		await(timeout, unit);
		assertThat(events).hasSize(1);
		return events.get(0);
	}
	
	private void await(long timeout, TimeUnit unit) throws InterruptedException {
		assertThat(lock.await(timeout, unit)).isTrue();
	}
}