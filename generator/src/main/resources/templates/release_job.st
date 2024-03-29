<?xml version='1.1' encoding='UTF-8'?>
<maven2-moduleset plugin="maven-plugin@3.4">
  <actions/>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <hudson.security.AuthorizationMatrixProperty>
      <inheritanceStrategy class="org.jenkinsci.plugins.matrixauth.inheritance.InheritParentStrategy"/>
      $owners:{ name |<permission>USER:hudson.model.Item.Read:$name$</permission>
<permission>USER:hudson.model.Run.Delete:$name$</permission>
<permission>USER:hudson.model.Run.Update:$name$</permission>
<permission>USER:hudson.model.Item.Workspace:$name$</permission>
<permission>USER:hudson.model.Item.Build:$name$</permission>
<permission>USER:hudson.model.Item.Release:$name$</permission>};
       separator="\n"$
    </hudson.security.AuthorizationMatrixProperty>
    <jenkins.model.BuildDiscarderProperty>
      <strategy class="hudson.tasks.LogRotator">
        <daysToKeep>-1</daysToKeep>
        <numToKeep>50</numToKeep>
        <artifactDaysToKeep>-1</artifactDaysToKeep>
        <artifactNumToKeep>-1</artifactNumToKeep>
      </strategy>
    </jenkins.model.BuildDiscarderProperty>
  </properties>
  <scm class="hudson.plugins.git.GitSCM" plugin="git@3.12.1">
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
        <name>$branch$</name>
      </hudson.plugins.git.BranchSpec>
    </branches>
    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
    <submoduleCfg class="list"/>
    <extensions>
      <hudson.plugins.git.extensions.impl.WipeWorkspace/>
      <hudson.plugins.git.extensions.impl.PerBuildTag/>
      <hudson.plugins.git.extensions.impl.LocalBranch>
        <localBranch>$branch$</localBranch>
      </hudson.plugins.git.extensions.impl.LocalBranch>
      <hudson.plugins.git.extensions.impl.PreBuildMerge>
        <options>
          <mergeRemote>origin</mergeRemote>
          <mergeTarget>$branch$</mergeTarget>
          <mergeStrategy>default</mergeStrategy>
          <fastForwardMode>FF</fastForwardMode>
        </options>
      </hudson.plugins.git.extensions.impl.PreBuildMerge>
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
  <mavenName>Maven 3.2.5</mavenName>
  <aggregatorStyleBuild>true</aggregatorStyleBuild>
  <incrementalBuild>false</incrementalBuild>
  <ignoreUpstremChanges>false</ignoreUpstremChanges>
  <ignoreUnsuccessfulUpstreams>false</ignoreUnsuccessfulUpstreams>
  <archivingDisabled>false</archivingDisabled>
  <siteArchivingDisabled>false</siteArchivingDisabled>
  <fingerprintingDisabled>false</fingerprintingDisabled>
  <resolveDependencies>false</resolveDependencies>
  <processPlugins>false</processPlugins>
  <mavenValidationLevel>0</mavenValidationLevel>
  <runHeadless>false</runHeadless>
  <disableTriggerDownstreamProjects>false</disableTriggerDownstreamProjects>
  <blockTriggerWhenBuilding>true</blockTriggerWhenBuilding>
  <settings class="jenkins.mvn.DefaultSettingsProvider"/>
  <globalSettings class="jenkins.mvn.DefaultGlobalSettingsProvider"/>
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
    <org.jvnet.hudson.plugins.m2release.M2ReleaseBuildWrapper plugin="m2release@0.15.0">
      <scmUserEnvVar></scmUserEnvVar>
      <scmPasswordEnvVar></scmPasswordEnvVar>
      <releaseEnvVar>IS_M2RELEASEBUILD</releaseEnvVar>
      <releaseGoals>-DskipStaging=true -Psign release:prepare release:perform</releaseGoals>
      <dryRunGoals>-Dresume=false -DdryRun=true release:prepare</dryRunGoals>
      <selectCustomScmCommentPrefix>false</selectCustomScmCommentPrefix>
      <selectAppendHudsonUsername>false</selectAppendHudsonUsername>
      <selectScmCredentials>false</selectScmCredentials>
      <numberOfReleaseBuildsToKeep>0</numberOfReleaseBuildsToKeep>
    </org.jvnet.hudson.plugins.m2release.M2ReleaseBuildWrapper>
  </buildWrappers>
  <prebuilders/>
  <postbuilders>
    <hudson.tasks.Shell>
      <command>git push origin $branch$ `git tag | grep -v ^jenkins`</command>
    </hudson.tasks.Shell>
  </postbuilders>
  <runPostStepsIfResult>
    <name>SUCCESS</name>
    <ordinal>0</ordinal>
    <color>BLUE</color>
    <completeBuild>true</completeBuild>
  </runPostStepsIfResult>
</maven2-moduleset>
