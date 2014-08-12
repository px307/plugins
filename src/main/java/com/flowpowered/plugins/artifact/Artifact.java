package com.flowpowered.plugins.artifact;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Artifact {
    private Queue<ArtifactJob> jobQueue = new ConcurrentLinkedQueue<>();
    private ArtifactState state = ArtifactState.UNDEFINED;
    private volatile boolean gone = false;

    public ArtifactState getState() {
        return state;
    }

    /**
     * Should be only called from the thread that is currently executing {@link ArtifactManager#pulse(String)}
     */
    public void setState(ArtifactState state) {
        this.state = state;
    }

    public Queue<ArtifactJob> getJobQueue() {
        return jobQueue;
    }

    public boolean isGone() {
        return gone;
    }

    protected void makeGone() {
        this.gone = true;
    }
}