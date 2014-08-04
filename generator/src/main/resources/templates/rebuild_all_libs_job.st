<?xml version='1.0' encoding='UTF-8'?>
<project>
  <actions/>
  <description>This is a placeholder job. It can be used to trigger new builds of all contrib libraries.</description>
  <logRotator>
    <daysToKeep>-1</daysToKeep>
    <numToKeep>-1</numToKeep>
    <artifactDaysToKeep>-1</artifactDaysToKeep>
    <artifactNumToKeep>-1</artifactNumToKeep>
  </logRotator>
  <keepDependencies>false</keepDependencies>
  <properties/>
  <scm class="hudson.scm.NullSCM"/>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <jdk>(Default)</jdk>
  <triggers class="vector">
    <hudson.triggers.TimerTrigger>
      <spec>0 1 * * 0</spec>
    </hudson.triggers.TimerTrigger>
  </triggers>
  <concurrentBuild>false</concurrentBuild>
  <builders/>
  <publishers>
    <hudson.tasks.BuildTrigger>
      <childProjects>$libs;separator=", "$</childProjects>
      <threshold>
        <name>SUCCESS</name>
        <ordinal>0</ordinal>
        <color>BLUE</color>
      </threshold>
    </hudson.tasks.BuildTrigger>
  </publishers>
  <buildWrappers/>
</project>