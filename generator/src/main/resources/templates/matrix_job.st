<?xml version='1.0' encoding='UTF-8'?>
<matrix-project plugin="matrix-project@1.7.1">
  <actions/>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <hudson.security.AuthorizationMatrixProperty>
      $owners:{ name |<permission>hudson.model.Item.Read:$name$</permission>
<permission>hudson.model.Run.Delete:$name$</permission>
<permission>hudson.model.Run.Update:$name$</permission>
<permission>hudson.model.Item.Workspace:$name$</permission>
<permission>hudson.model.Item.Build:$name$</permission>};
       separator="\n"$
    </hudson.security.AuthorizationMatrixProperty>
    <jenkins.model.BuildDiscarderProperty>
      <strategy class="hudson.tasks.LogRotator">
        <daysToKeep>-1</daysToKeep>
        <numToKeep>10</numToKeep>
        <artifactDaysToKeep>-1</artifactDaysToKeep>
        <artifactNumToKeep>-1</artifactNumToKeep>
      </strategy>
    </jenkins.model.BuildDiscarderProperty>
  </properties>
  <scm class="hudson.plugins.git.GitSCM" plugin="git@3.0.1">
    <configVersion>2</configVersion>
    <userRemoteConfigs>
      <hudson.plugins.git.UserRemoteConfig>
        <name>origin</name>
        <refspec>+refs/heads/*:refs/remotes/origin/*</refspec>
        <url>git@github.com:clojure/$name$.git</url>
        <credentialsId>clojure-build</credentialsId>
      </hudson.plugins.git.UserRemoteConfig>
    </userRemoteConfigs>
    <branches>
      <hudson.plugins.git.BranchSpec>
        <name>master</name>
      </hudson.plugins.git.BranchSpec>
    </branches>
    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
    <submoduleCfg class="list"/>
    <extensions>
      <hudson.plugins.git.extensions.impl.WipeWorkspace/>
      <hudson.plugins.git.extensions.impl.LocalBranch>
        <localBranch>master</localBranch>
      </hudson.plugins.git.extensions.impl.LocalBranch>
    </extensions>
  </scm>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <triggers/>
  <concurrentBuild>false</concurrentBuild>
  <axes>
    <hudson.matrix.JDKAxis>
      <name>jdk</name>
      <values>
        $jdks:{ name | <string>$name$</string>}; separator="\n"$
      </values>
    </hudson.matrix.JDKAxis>
    <hudson.matrix.TextAxis>
      <name>CLOJURE_VERSION</name>
      <values>
        $clojures:{ name | <string>$name$</string>}; separator="\n"$
      </values>
    </hudson.matrix.TextAxis>
  </axes>
  <builders>
    <hudson.tasks.Maven>
      <targets>-Dclojure.version=\$CLOJURE_VERSION clean test</targets>
      <mavenName>Maven 2.2.1</mavenName>
      <usePrivateRepository>false</usePrivateRepository>
      <settings class="jenkins.mvn.DefaultSettingsProvider"/>
      <globalSettings class="jenkins.mvn.DefaultGlobalSettingsProvider"/>
      <injectBuildVariables>true</injectBuildVariables>
    </hudson.tasks.Maven>
  </builders>
  <publishers/>
  <buildWrappers/>
  <executionStrategy class="hudson.matrix.DefaultMatrixExecutionStrategyImpl">
    <runSequentially>false</runSequentially>
  </executionStrategy>
</matrix-project>
