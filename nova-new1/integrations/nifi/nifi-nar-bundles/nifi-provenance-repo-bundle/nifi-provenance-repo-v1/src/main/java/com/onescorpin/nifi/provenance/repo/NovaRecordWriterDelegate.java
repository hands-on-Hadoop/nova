package com.onescorpin.nifi.provenance.repo;

/*-
 * #%L
 * onescorpin-nifi-provenance-repo
 * %%
 * Copyright (C) 2017 Onescorpin
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.apache.nifi.provenance.ProvenanceEventRecord;
import org.apache.nifi.provenance.serialization.RecordWriter;
import org.apache.nifi.provenance.toc.TocWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class NovaRecordWriterDelegate implements RecordWriter {

    private static final Logger log = LoggerFactory.getLogger(NovaRecordWriterDelegate.class);

    private RecordWriter recordWriter;

    public NovaRecordWriterDelegate(RecordWriter recordWriter) {
        this.recordWriter = recordWriter;
    }

    @Override
    public void writeHeader(long l) throws IOException {
        recordWriter.writeHeader(l);
    }


    @Override
    public void flush() throws IOException {
        recordWriter.flush();
    }

    @Override
    public int getRecordsWritten() {
        return recordWriter.getRecordsWritten();
    }

    @Override
    public File getFile() {
        return recordWriter.getFile();
    }

    @Override
    public void lock() {
        recordWriter.lock();
    }

    @Override
    public void unlock() {
        recordWriter.unlock();
    }

    @Override
    public boolean tryLock() {
        return recordWriter.tryLock();
    }

    @Override
    public void markDirty() {
        recordWriter.markDirty();
    }

    @Override
    public void sync() throws IOException {
        recordWriter.sync();
    }

    @Override
    public TocWriter getTocWriter() {
        return recordWriter.getTocWriter();
    }

    @Override
    public boolean isClosed() {
        return recordWriter.isClosed();
    }

    public synchronized void close() throws IOException {
        this.recordWriter.close();
    }

    @Override
    public long writeRecord(ProvenanceEventRecord provenanceEventRecord, long eventId) throws IOException {
        long bytesWritten = recordWriter.writeRecord(provenanceEventRecord, eventId);
        NflowStatisticsManager.getInstance().addEvent(provenanceEventRecord, eventId);
        return bytesWritten;
    }



    /*
NiFi 1.2 method

 public StorageSummary writeRecord(ProvenanceEventRecord provenanceEventRecord) throws IOException {
        StorageSummary storageSummary = recordWriter.writeRecord(provenanceEventRecord);
        //record it to the queue
        processingQueue.put(provenanceEventRecord);
        return storageSummary;

    }

    @Override
    public long getBytesWritten() {
        return 0;
    }

    @Override
    public boolean isDirty() {
        return false;
    }
    */
}
