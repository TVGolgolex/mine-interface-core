package de.pascxl.minecraft.minecore.server;

import eu.cloudnetservice.driver.service.ServiceEnvironmentType;
import eu.cloudnetservice.driver.service.ServiceInfoSnapshot;
import lombok.Data;
import lombok.NonNull;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Pascal K. on 16.05.2023.
 */
@Data
public class Server {

    private final String taskName;
    private final UUID uniqueId;
    private final int taskServiceId;
    private final ServiceEnvironmentType environment;
    private String nameSplitter;
    private int onlineCount;
    private Set<String> allowedNodes;
    private String nodeUniqueId;
    private String environmentName;
    private ServiceInfoSnapshot lastServiceInfoSnapshot;
    private ServerActivity serverActivity;
    private ServerLifeCycle serverLifeCycle;

    public Server(@NonNull String taskName,
                  @NonNull String nameSplitter,
                  @NonNull Set<String> allowedNodes,
                  @NonNull UUID uniqueId,
                  int taskServiceId,
                  @NonNull String nodeUniqueId,
                  @NonNull String environmentName,
                  @NonNull ServiceEnvironmentType environment,
                  @NonNull ServiceInfoSnapshot lastServiceInfoSnapshot,
                  @NonNull ServerActivity serverActivity,
                  @NotNull ServerLifeCycle serverLifeCycle) {
        this.taskName = taskName;
        this.nameSplitter = nameSplitter;
        this.allowedNodes = allowedNodes;
        this.uniqueId = uniqueId;
        this.taskServiceId = taskServiceId;
        this.nodeUniqueId = nodeUniqueId;
        this.environmentName = environmentName;
        this.environment = environment;
        this.lastServiceInfoSnapshot = lastServiceInfoSnapshot;
        this.serverActivity = serverActivity;
        this.serverLifeCycle = serverLifeCycle;
    }

    public String getName() {
        return this.taskName + this.nameSplitter + this.taskServiceId;
    }

    public Document toDocument() {
        return new Document("taskName", taskName)
                .append("nameSplitter", nameSplitter)
                .append("onlineCount", onlineCount)
                .append("allowedNodes", allowedNodes)
                .append("uniqueId", uniqueId.toString())
                .append("taskServiceId", taskServiceId)
                .append("nodeUniqueId", nodeUniqueId)
                .append("environmentName", environmentName)
                .append("environment", environment.name())
                .append("lastServiceInfoSnapshot", lastServiceInfoSnapshot.toString())
                .append("serverActivity", serverActivity.name())
                .append("serverLifeCycle", serverLifeCycle.name())
                ;
    }

}
