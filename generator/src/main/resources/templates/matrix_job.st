<?xml version='1.0' encoding='UTF-8'?>
<matrix-project>
  <actions/>
  <description></description>
  <logRotator>
    <daysToKeep>-1</daysToKeep>
    <numToKeep>10</numToKeep>
    <artifactDaysToKeep>-1</artifactDaysToKeep>
    <artifactNumToKeep>-1</artifactNumToKeep>
  </logRotator>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <scm class="hudson.plugins.git.GitSCM">
    <configVersion>1</configVersion>
    <remoteRepositories>
      <org.spearce.jgit.transport.RemoteConfig>
        <string>origin</string>
        <int>5</int>
        <string>fetch</string>
        <string>+refs/heads/*:refs/remotes/origin/*</string>
        <string>receivepack</string>
        <string>git-upload-pack</string>
        <string>uploadpack</string>
        <string>git-upload-pack</string>
        <string>url</string>
        <string>git@github.com:clojure/$name$.git</string>
        <string>tagopt</string>
        <string></string>
      </org.spearce.jgit.transport.RemoteConfig>
    </remoteRepositories>
    <branches>
      <hudson.plugins.git.BranchSpec>
        <name>master</name>
      </hudson.plugins.git.BranchSpec>
    </branches>
    <localBranch></localBranch>
    <mergeOptions/>
    <recursiveSubmodules>false</recursiveSubmodules>
    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
    <authorOrCommitter>false</authorOrCommitter>
    <clean>false</clean>
    <wipeOutWorkspace>true</wipeOutWorkspace>
    <pruneBranches>false</pruneBranches>
    <buildChooser class="hudson.plugins.git.util.DefaultBuildChooser"/>
    <gitTool>Default</gitTool>
    <submoduleCfg class="list"/>
    <relativeTargetDir></relativeTargetDir>
    <excludedRegions></excludedRegions>
    <excludedUsers></excludedUsers>
  </scm>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <triggers class="vector"/>
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
    </hudson.tasks.Maven>
  </builders>
  <publishers/>
  <buildWrappers/>
  <runSequentially>false</runSequentially>
</matrix-project>