<?xml version='1.0' encoding='UTF-8'?>
<maven2-moduleset plugin="maven-plugin@1.386">
  <actions/>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <hudson.security.AuthorizationMatrixProperty>
      $owners:{ name |<permission>hudson.model.Item.Read:$name$</permission>
<permission>hudson.model.Run.Delete:$name$</permission>
<permission>hudson.model.Run.Update:$name$</permission>
<permission>hudson.model.Item.Workspace:$name$</permission>
<permission>hudson.model.Item.Build:$name$</permission>
<permission>hudson.model.Item.Release:$name$</permission>};
       separator="\n"$
    </hudson.security.AuthorizationMatrixProperty>
    <jenkins.model.BuildDiscarderProperty>
      <strategy class="hudson.tasks.LogRotator">
        <daysToKeep>-1</daysToKeep>
        <numToKeep>100</numToKeep>
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
      <hudson.plugins.git.extensions.impl.PerBuildTag/>
      <hudson.plugins.git.extensions.impl.LocalBranch>
        <localBranch>master</localBranch>
      </hudson.plugins.git.extensions.impl.LocalBranch>
    </extensions>
  </scm>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <jdk>$jdk$</jdk>
  <triggers>
    <hudson.triggers.SCMTrigger>
      <spec>@hourly</spec>
      <ignorePostCommitHooks>false</ignorePostCommitHooks>
    </hudson.triggers.SCMTrigger>
  </triggers>
  <concurrentBuild>false</concurrentBuild>
  <rootModule>
    <groupId>org.clojure</groupId>
    <artifactId>$name$</artifactId>
  </rootModule>
  <goals>--fail-at-end clean deploy</goals>
  <mavenName>Maven 2.2.1</mavenName>
  <aggregatorStyleBuild>true</aggregatorStyleBuild>
  <incrementalBuild>false</incrementalBuild>
  <usePrivateRepository>false</usePrivateRepository>
  <ignoreUpstremChanges>false</ignoreUpstremChanges>
  <archivingDisabled>false</archivingDisabled>
  <reporters/>
  <publishers>
    <hudson.tasks.BuildTrigger>
      <childProjects>$name$-test-matrix</childProjects>
      <threshold>
        <name>SUCCESS</name>
        <ordinal>0</ordinal>
        <color>BLUE</color>
        <completeBuild>true</completeBuild>
      </threshold>
    </hudson.tasks.BuildTrigger>
  </publishers>
  <buildWrappers>
    <hudson.plugins.m2extrasteps.M2ExtraStepsWrapper plugin="m2-extra-steps@1.1.3">
      <preBuildSteps/>
      <postBuildSteps>
        <hudson.tasks.Shell>
          <command>git push origin master `git tag | grep -v ^jenkins`</command>
        </hudson.tasks.Shell>
      </postBuildSteps>
      <runIfResult>success</runIfResult>
    </hudson.plugins.m2extrasteps.M2ExtraStepsWrapper>
    <org.jvnet.hudson.plugins.m2release.M2ReleaseBuildWrapper>
      <releaseGoals>release:prepare release:perform -Psonatype-oss-release -Dgoals=&quot;deploy nexus-staging:release&quot;</releaseGoals>
      <defaultVersioningMode>specify_version</defaultVersioningMode>
      <selectCustomScmCommentPrefix>false</selectCustomScmCommentPrefix>
      <selectAppendHudsonUsername>false</selectAppendHudsonUsername>
    </org.jvnet.hudson.plugins.m2release.M2ReleaseBuildWrapper>
  </buildWrappers>
</maven2-moduleset>
